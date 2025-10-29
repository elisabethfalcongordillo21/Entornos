package poo;
public class Main {
    public static void main(String[] args) throws Exception {
        PersonaPoo persona1 = new PersonaPoo("Ruben", 26);
        PersonaPoo persona2 = new PersonaPoo("Mario", 18);

        persona1.setDireccion("Huelva,2");
        persona2.setDireccion("El Puerto de Santa Maria ");
        persona1.setApellido("Vallejo Pedrosa");
        persona2.setApellido("Ponce");
        persona1.setDNI("45386699E");
        persona2.setDNI("45386655R");
        persona1.setEmail("rubenvallejo@gmail.com");
        persona2.setEmail("marioponce@gmail.com");
        persona1.setTelefono("+34664039072");
        persona2.setTelefono("+34664039078");
        persona1.setProfesion("Cantante");
        persona2.setProfesion("Portero");
        persona1.setAnios_experiencia("10");
        persona2.setAnios_experiencia("4");
        persona1.MostrarInformacion();
        persona2.MostrarInformacion();

        System.out.println("Para la persona 1 sabemos que tiene " + persona1.getEdad() + " años.");


    }
}
