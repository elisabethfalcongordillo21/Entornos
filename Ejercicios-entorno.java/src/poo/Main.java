package poo;
public class Main {
    public static void main(String[] args) throws Exception {

        //Personas
        PersonaPoo persona1 = new PersonaPoo("Eli",19,"c/Agua", "Falcon Gordillo", "75388632D", "efalgor1806@g.educaand.es","+3485921475", "Estudiante", "Cinco");
        PersonaPoo persona2 = new PersonaPoo("Maria",18,"c/Fuego","Guapetona", "746678645H", "marialaguapa@gmail.com", "+346521785", "Profesora", "Siete");


        System.out.println("Datos persona 1");
        persona1.MostrarInformacion();
        persona1.estaJubilado();
        System.out.println("Datos persona 2");
        persona2.MostrarInformacion();
        persona2.estaJubilado();
    /******************************************************************************************************************************************************************************************************************************************************************************************************* */
    //Libro
        Libro libro1 = new Libro("El Señor de los Anillos","978-0261103573","Minotauro","Español",576,1954,true);
        Libro libro2 = new Libro("1984","978-0451524935","Signet Classics","Ingles",328,1949,false);
        
        System.out.println("Datos libro 1: ");
        libro1.informacion();
        libro1.estaDisponible();
        libro1.esExtranjero();
        System.out.println("Datos del libro 2: ");
        libro2.informacion();
        libro2.estaDisponible();
        libro2.esExtranjero();
    
    /***************************************************************************************************************************************************************************************************************************************************************************** */

    //Libro fisico y digital
    LibroFisico libroFisico1 = new LibroFisico("Harry Potter y la piedra filosofal","978-8478884452","Salamandra","Español",256,1997,true,"Estantería");
    LibroDigital libroDigital1 = new LibroDigital("El marciano","978-0804139021","Crown","Inglés",400,2014,true,"EPUB",5);
    System.out.println("Informacion libro fisico");
    libroFisico1.informacion();
    System.out.println("Informacion libro digital");
    libroDigital1.informacion();

    /****************************************************************************************************************************************************************************************************************************************************************************************** */
    //usuario y empleado
    Usuario usuario1 = new Usuario("Mauricio", 25,"c/Hielo 10","Colmenero","5167653577J","mauriciocolmenero@gmail.com","+34562287862","Camarero","Siete",123);
    Empleado empleado1 = new Empleado("Javier",40,"c/Argentina","Maroto","87454136L","javiermaroto@gmail.com","+34521398732","Bibliotecario","Diez","Jefe",1500.50);
    System.out.println("Datos usuario ");
    usuario1.addLibrosPrestados(libro1);
    usuario1.addLibrosPrestados(libroDigital1);
    usuario1.devolverLibro(libroDigital1);
    usuario1.MostrarInformacion();
    System.out.println("Datos empleado");
    empleado1.MostrarInformacion();
/************************************************************************************************************************************************************************************************************************************************************************************ */
    //Sala
    
    Sala sala1 = new Sala("Alfa",20,true,"Estudio",true);
    Sala sala2 = new Sala("Beta",35,false,"Lectura",false);

    System.out.println("Datos sala 1 ");
    sala1.setPersonaResponsable(persona1);
    sala1.tienePizarra();
    sala1.estaDisponible();
    sala1.getPersonaResponsable();
    sala1.informacion();
    
    System.out.println("Datos sala 2");
    sala2.setPersonaResponsable(persona2);
    sala2.tienePizarra();
    sala2.estaDisponible();
    sala2.getPersonaResponsable();
    sala2.informacion();

    //entran y salen de sala
    System.out.println("Entran personas");
    sala1.entrarPersona(persona1);
    sala1.entrarPersona(persona2);
    System.out.println("Personas existentes en la sala 1");
    sala1.mostrarPersonas();
    System.out.println("Salen personas");
    sala1.salirPersona(persona2);
    sala1.mostrarPersonas();
    
/************************************************************************************************************************************************************************** */

    //salas y añadir libros en sala lectura

    System.out.println("Añadir libro en la sala de lectura");
    SalaLectura salaLectura = new SalaLectura("Sala de lectura norte", 28,false,"Lectura", true);

    //añadir libro a la sala
    salaLectura.addListaLibros(libro1);
    salaLectura.addListaLibros(libro2);

    SalaEstudio salaEstudio = new SalaEstudio("Lengua",18,false,"Especializada", true,20);
    SalaInformatica salaInformatica = new SalaInformatica("Robotica", 30,true,"Especializada",true,35);
    
    salaLectura.informacion();
    salaLectura.mostrarLibros();

    salaEstudio.informacion();
    salaInformatica.informacion();

/************************************************************************************************************************************************************************************* */

    //biblioteca
    Biblioteca biblioteca1 = new Biblioteca("Biblioteca Central","Avenida Andalucia,45,Sevilla",8,20);
    Biblioteca biblioteca2 = new Biblioteca("Biblioteca Norte", "Calle los Pinos,12,Barcelona",10,22);

    System.out.println("Datos biblioteca 1");
    biblioteca1.mostrarInformacion();
    biblioteca1.estaAbierta(11);
    biblioteca1.mostrarTotalPersonas();
    System.out.println("Datos biblioteca 2");
    biblioteca2.mostrarInformacion();
    biblioteca2.estaAbierta(12);
    biblioteca2.mostrarTotalPersonas();
    
    //registro personas biblio 1

    System.out.println("Resgistro de  personas en la biblioteca 1");
    biblioteca1.registroVisita(persona1);
    biblioteca1.registroVisita(persona2);

    //añadir salas a la biblio 1

    System.out.println("Añadir salas especificas a la biblioteca 1");
    biblioteca1.addSala(salaInformatica);
    biblioteca1.addSala(salaEstudio);

    //añadir y eliminar libros
    System.out.println("Añadimos libros a la biblioteca 1");
    biblioteca1.addLibro(libroDigital1);
    biblioteca1.addLibro(libroFisico1);
    
    System.out.println("Eliminamos libro de la biblioteca 1");
    biblioteca1.removeLibro(libroDigital1);

    System.out.println("Añadir salas a biblioteca 1");
    biblioteca1.addSala(sala1);
    biblioteca1.addSala(sala2);

    System.out.println("Mostrar informacion de la biblioteca 1 ");
    biblioteca1.mostrarInformacion();

    //mostrar libros y salas en la biblio 1
    System.out.println("Libros en la biblioteca 1");
    biblioteca1.mostrarLibros();
    System.out.println("Salas en la biblioteca 1");
    biblioteca1.mostrarSalas();
    //mostrar salas disponibles en  la biblioteca 1
    System.out.println("Salas disponibles en la biblioteca 1");
    biblioteca1.mostrarSalasDisponibles();

    //registrar visita o prestamo
    System.out.println("Visitante biblioteca");
    biblioteca1.registroVisita(persona2);
    System.out.println("Libro prestados");
    biblioteca1.registrarPrestamo(persona2, libroDigital1);

    //persona responsable
    System.out.println("Persona responsable de la biblioteca 1");
    biblioteca1.asignarResponsable(salaEstudio,persona1);



}
}
