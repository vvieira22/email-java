package emailjava;

import java.util.Scanner;
import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

public class EmailJava {
    public static void main(String[] args) {
           
        int escolha;
        
        Scanner ler= new Scanner(System.in);
        
        do{
            System.out.println("Qual o tipo do seu Email?");
            System.out.println("1- Gmail");
            System.out.println("2- Outlook/Hotmail");
            System.out.println("3- Sair");

            escolha=ler.nextInt();

            if(escolha==1){
                String Email;
                String Senha;
                
                System.out.println("Antes de continuar precisamos autenticar o email de envio");
                
                System.out.println("Qual seu Email? ");
                Email=ler.next();
                
                System.out.println("Qual a senha de dispositivo? ");
                Senha=ler.next();
                
                SimpleEmail email= new SimpleEmail();              
                Email gmail= new Email(Email,Senha); 

                email.setHostName("smtp.gmail.com");
                email.setSmtpPort(587);
                email.setAuthenticator(new DefaultAuthenticator(gmail.getEmail(),gmail.getSenha()));
                email.setSSLOnConnect(true); //ativar conexao de forma segura
                                
                try {
                    //DE ONDE O EMAIL VAI SAIR
                    
                    String Assunto;
                    String Mensagem;
                    String destinatario;
                    
                    System.out.println("Destinatario: ");
                    destinatario=ler.next();
                    
                    System.out.println("Assunto da mensagem: ");                    
                    Assunto=ler.next();
                    
                    System.out.println("Mensagem: ");                    
                    Mensagem=ler.next();
                                       
                    email.setFrom(gmail.getEmail()); //email de:
                    email.setSubject(Assunto); //Assunto
                    email.setMsg(Mensagem);
                    
                    email.addTo(destinatario);//email para:
                    email.send();  
                    
                    System.out.println("Mensagem Enviada com Sucesso !!");
                    
                } catch (Exception e) {
                    e.printStackTrace();
                }
                
            }

            if(escolha==2){
                 String Email;
                String Senha;
                
                System.out.println("Antes de continuar precisamos autenticar o email de envio");
                
                System.out.println("Qual seu Email? ");
                Email=ler.next();
                
                System.out.println("Qual a senha de dispositivo? ");
                Senha=ler.next();
                
                SimpleEmail email= new SimpleEmail();              
                Email outlook= new Email(Email,Senha); 

                email.setSmtpPort(25);
                email.setHostName("smtp.office365.com");
                email.setAuthenticator(new DefaultAuthenticator(outlook.getEmail(),outlook.getSenha()));
                email.setSSLOnConnect(true); //ativar conexao de forma segura
                
                try {
                    //DE ONDE O EMAIL VAI SAIR
                    
                    String Assunto;
                    String Mensagem;
                    String destinatario;
                    
                    System.out.println("Destinatario: ");
                    destinatario=ler.next();
                    
                    System.out.println("Assunto da mensagem: ");                    
                    Assunto=ler.next();
                    
                    System.out.println("Mensagem: ");                    
                    Mensagem=ler.next();
                                       
                    email.setFrom(outlook.getEmail()); //email de:
                    email.setSubject(Assunto); //Assunto
                    email.setMsg(Mensagem);
                    
                    email.addTo(destinatario);//email para:
                    email.send();  
                    
                    System.out.println("Mensagem Enviada com Sucesso !!");
                    
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            
            if(escolha>2 || escolha<1){
                System.out.println("Escolha Inválida !");   
            }

        }while(escolha!=3);
    }
}
