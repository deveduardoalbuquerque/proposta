package br.com.zup.edu.proposta.util;

public enum PropostaAnalise {
    COM_RESTRINCAO, SEM_RESTRINCAO;

    public PropostaStatus convert(){
        if(this.equals(SEM_RESTRINCAO)){
            return PropostaStatus.ELEGIVEL;
        }else if(this.equals(COM_RESTRINCAO)){
            return PropostaStatus.NAO_ELEGIVEL;
        }
        return null;
    }

}
