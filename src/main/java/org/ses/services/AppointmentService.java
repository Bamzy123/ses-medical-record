package org.ses.services;

import org.ses.Dtos.AppointmentRequestDTO;
import org.ses.exceptions.AppointmentSlotUnavailableException;
import org.ses.models.Appointment;
import org.ses.models.Doctor;
import org.ses.models.Patient;
import org.ses.repositories.AppointmentRepository;
import org.ses.repositories.DoctorRepository;
import org.ses.repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class AppointmentService {
    @Service
    public class AppointmentService {

        private final AppointmentRepository appointmentRepository;

        private final PatientRepository patientRepository;

        private final DoctorRepository doctorRepository;

        public AppointmentService(AppointmentRepository appointmentRepository, PatientRepository patientRepository, DoctorRepository doctorRepository) {
            this.appointmentRepository = appointmentRepository;
            this.patientRepository = patientRepository;
            this.doctorRepository = doctorRepository;
        }

        public Appointment bookAppointment(AppointmentRequestDTO dto) {
            Patient patient = patientRepository.findByEmail(dto.getPatientEmail())
                    .orElseThrow(() -> new IllegalArgumentException("Patient not found"));
            Doctor doctor = doctorRepository.findByEmail(dto.getDoctorEmail())
                    .orElseThrow(() -> new IllegalArgumentException("Doctor not found"));

            LocalDate appointmentTime = dto.getAppointmentDateTime();
            // Check if the doctor has an appointment at the given slot
            List<Appointment> appointments = appointmentRepository
                    .findByDoctorEmailAndAppointmentDateTime(doctor.getEmail(), appointmentTime);
            if (!appointments.isEmpty()) {
                throw new AppointmentSlotUnavailableException("The appointment slot is already booked.");
            }
            Appointment appointment = new Appointment(patient, doctor, appointmentTime);
            return appointmentRepository.save(appointment);
        }

        public Appointment approveAppointment(String appointmentId, boolean approval) {
            Appointment appointment = appointmentRepository.findById(appointmentId)
                    .orElseThrow(() -> new IllegalArgumentException("Appointment not found"));
            appointment.setApproved(approval);
            return appointmentRepository.save(appointment);
        }
}
