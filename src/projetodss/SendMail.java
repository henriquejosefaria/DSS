package projetodss;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendMail {
        /** Construtor parametrizado da classe SendMail.
     *  @param ficha FichaCliente correspondente à ficha do cliente que perdeu a password.
    */
	public SendMail(Aluno aluno) {

		final String user = "costumeranafreitas@gmail.com";
		final String password = "poo20172018";

		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");

		Session session = Session.getInstance(props,
		  new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(user, password);
			}
		  });

		try {


			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(aluno.getEmail()));
			message.setRecipients(Message.RecipientType.TO,
			InternetAddress.parse(aluno.getEmail()));
			message.setSubject("Recuperação de password da Aplicação DSS-2017-2018");
			message.setContent("Caro " +aluno.getNome()+ ",<html><br/>Muito obrigado por usar os Serviços DSS-20172018 da universidade Minho. <br/> Recebemos um pedido de recuperação de dados da conta associada ao Numero: </html>" +aluno.getNumero()+"<html> no nosso sistema.<br/> Estes são os seus dados </html>"+aluno.getNome()+":<html><br/><br/>Nome: </html>"+aluno.getNome()+ "<html><br/>Numero: </html>"+aluno.getNumero()+"<html><br/>Morada: </html>"+aluno.getMorada()+"<html><br/>Email: </html>"+aluno.getEmail()+"<br/>Password: "+ aluno.getPassword() +"<br/><br/>Espero que tenha recebido os dados que procurava.<br/> Se alguma duvida persistir não hesite em contactar o nosso suporte em <a href=https://www.uminho.pt/PT>https://www.uminho.pt/PT</a><br/>Atenciosamente<br/>Ana Freitas <br/>UMinho!<br/><br/><img src='http://join.di.uminho.pt/images/org/ee-um.png' alt='https://www.uminho.pt/PT' style='width:400px;height:200px;'></html>", "text/html; charset=utf-8");
			Transport.send(message);
			
			
		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}
}