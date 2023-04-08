package com.mttech.lancamentos.domain;

public enum TipoLancamentoEnum {

    CREDITO {
        public String toString() {
            return "C";
        }
    },

    DEBITO {
        public String toString() {
            return "D";
        }
    }

}
