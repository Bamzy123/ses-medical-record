package org.ses.services;

import org.ses.Dtos.AppointmentRequestDTO;
import org.ses.exceptions.AppointmentSlotUnavailableException;
import org.ses.exceptions.DoctorNotFoundException;
import org.ses.exceptions.PatientNotFoundException;
import org.ses.models.Appointment;
import org.ses.models.Doctor;
import org.ses.models.Patient;
import org.ses.repositories.AppointmentRepository;
import org.ses.repositories.DoctorRepository;
import org.ses.repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class AppointmentService {

    private final AppointmentRepository appointmentRepository;
    private final PatientRepository patientRepository;
    private final DoctorRepository doctorRepository;

    @Autowired
    public AppointmentService(AppointmentRepository appointmentRepository, PatientRepository patientRepository, DoctorRepository doctorRepository) {
        this.appointmentRepository = appointmentRepository;
        this.patientRepository = patientRepository;
        this.doctorRepository = doctorRepository;
    }

    public Appointment bookAppointment(AppointmentRequestDTO dto) {
        Patient patient = patientRepository.findByEmail(dto.getPatientEmail())
                .orElseThrow(() -> new PatientNotFoundException("Patient not found"));
        Doctor doctor = doctorRepository.findByEmail(dto.getDoctorEmail())
                .orElseThrow(() -> new DoctorNotFoundException("Doctor not found"));

        LocalDateTime appointmentDateTime = dto.getAppointmentDateTime();

        List<Appointment> appointments = appointmentRepository
                .findByDoctorEmailAndAppointmentDateTime(doctor.getEmail(), appointmentDateTime);
        if (!appointments.isEmpty()) {
            throw new AppointmentSlotUnavailableException("The appointment slot is already booked.");
        }

        Appointment appointment = new Appointment(patient, doctor, appointmentDateTime, true);
        return appointmentRepository.save(appointment);
    }

    public Appointment approveAppointment(String appointmentId, boolean approval) {
        Appointment appointment = appointmentRepository.findById(appointmentId)
                .orElseThrow(() -> new IllegalArgumentException("Appointment not found"));
        appointment.setApproved(approval);
        return appointmentRepository.save(appointment);
    }
}