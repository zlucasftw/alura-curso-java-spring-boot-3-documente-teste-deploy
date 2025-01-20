package br.com.alura.med.voll.api.enums.doctor;

public enum CancellationReason {

    PATIENT_GAVE_UP("Paciente desistiu"),
    DOCTOR_CANCELED("Médico cancelou"),
    OTHERS("Outros");

    private String cancellationMotive;

    CancellationReason(String cancellationMotive) {
        this.cancellationMotive = cancellationMotive;
    }

    public static CancellationReason fromText(String text) {
        for (CancellationReason reason : CancellationReason.values()) {
            if (reason.cancellationMotive.equalsIgnoreCase(text)) {
                return reason;
            }
        }
        throw new IllegalArgumentException("Invalid cancellation reason for the following text: " + text);
    }


}
