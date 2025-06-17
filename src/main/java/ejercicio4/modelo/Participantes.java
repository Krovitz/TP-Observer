package ejercicio4.modelo;

public class Participantes extends Sujeto {
    private RegistroParticipante registroDeParticipante;

    public Participantes(RegistroParticipante registroDeParticipante) {
        this.registroDeParticipante = registroDeParticipante;
    }

    public void nuevoParticipante(String nombre, String telefono, String region, String email) {
        var participante = new Participante(nombre, telefono, region);
        this.registroDeParticipante.registrar(participante);
        notificarObservadores(email);
    }
}
