package emailjava;

public class Email {
    private final String email;
    private final String senha;
    
    Email(String email, String senha){
        this.email=email;
        this.senha=senha;
    }

    public String getEmail() {
        return email;
    }

    public String getSenha() {
        return senha;
    }    
    
 }
