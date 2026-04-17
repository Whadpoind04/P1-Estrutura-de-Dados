import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Processo {
    private static int cont = 1;
    private int protocolo;
    private String solicitante;
    private String tipoServico;
    private int prioridade;
    private String dataHora;

    public Processo(String solicitante, String tipoServico, int prioridade){
        this.protocolo = cont++;
        this.solicitante = solicitante;
        this.tipoServico = tipoServico;
        this.prioridade = prioridade;
        this.dataHora = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"));
    }

    public int getProtocolo(){
        return protocolo;
    } 
    public String getSolicitante(){
        return solicitante;
    }
    public String getTipoServico(){
        return tipoServico;
    }
    public int getPrioridade(){
        return prioridade;
    }
    public String getDataHora(){
        return dataHora;
    }

    public void setSolicitante(String solicitante){
        this.solicitante = solicitante;
    }
    public void setTipoServico (String tipoServico){
        this.tipoServico = tipoServico;
    }
    public void setPrioridade (int prioridade){
        this.prioridade = prioridade;
    }
    public void setDataHora (String dataHora){
        this.dataHora = dataHora;
    }
    @Override
    public String toString(){
        String nivel =switch (prioridade){
        case 1 -> "Baixa";
        case 2 -> "Normal";
        case 3 -> "Urgente";
        default -> "Desconhecida";
        };
        return "["+protocolo+"]" +"["+solicitante +"]"  + "[" +tipoServico + "]" + "[" +nivel +"]"+ "["+dataHora +"]" ;

        
    }


}
