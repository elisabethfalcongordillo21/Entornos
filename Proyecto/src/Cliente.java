public class Cliente {
    private String nombre;
    private String correo;
    private String direccion;

    public Cliente(String nombre, String correo, String direccion)
    {
        this.nombre = nombre;
        this.correo = correo;
        this.direccion = direccion;
    }

    //getters y setters

    public String getNombre()
    {
        return nombre;
    }
    
    public void setNombre(String nombre)
    {
        this.nombre= nombre;
    }

    public String getCorreo()
    {
        return correo;
    }


    public void setCorreo(String correo) {
        this.correo = correo;
    }
    

    public void setCorreo(String correo)
    {
        this.correo;
    }


    public String getDireccion()
    {
        return direccion;
    }

    public void setDireccion(String direccion)
    {
        this.direccion=direccion;
    }


}



