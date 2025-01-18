package br.com.alura.med.voll.api.enums.doctor;

public enum CancellationReason {

    DESISTIU("Paciente desistiu"),
    CANCELOU("Médico cancelou"),
    OUTROS("Outros");

    private String reason;

    CancellationReason(String reason) {
        this.reason = reason;
    }


}
