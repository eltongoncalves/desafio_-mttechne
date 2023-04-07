# desafio_-mttechne

## Gerar imagem docker

Para gerar a imagem docker da api, execute:

    docker build -d apilancamento .

Esse comando é necessário para criar a imagem principal do projeto

## Usar docker composer para inicializar os servicos

Para que iniciar a api adequadamente é necessário ter os servicos: Mysql e PhpMyAdmin 

Para inicializar os servicos e a API lancamento, execute:

    docker-compose up --buld 


## Testar os servicos utilizando o postman 

Para realizar o lancamento de crédito 

    curl --location 'localhost:8080/lancamento/credito' \
    --header 'Content-Type: application/json' \
    --data '{
        "descricao": "Lancamento de crédito",
        "valor":  1.0
    }'

    Response: 
    {
        "id": 21,
        "descricao": "Lancamento de débito",
        "tipo": "C",
        "valor": 1.0,
        "saldo": 11.0,
        "dataHora": "2023-04-07T07:11:50.091066944Z"
    }

Para realizar o lancamento de débito 

   
    curl --location 'localhost:8080/lancamento/debito' \
    --header 'Content-Type: application/json' \
    --data '{
        "descricao": "Lancamento de débito",
        "valor":  1.0
    }'

    Response: 
     {
            "id": 20,
            "descricao": "Lancamento de débito",
            "tipo": "D",
            "valor": 1.0,
            "saldo": 10.0,
            "dataHora": "2023-04-07T07:10:27.864819308Z"
     }      


Para gerar o relatório diário consolidado 

    curl --location 'localhost:8080/relatorio/saldo/2023-04-07 '

    response: 

    {
        "saldoConsolidadoTotal": 10.0,
        "saldoConsolidadoCredito": 14.0,
        "saldoConsolidadoDebito": 4.0,
        "lancamentos": [
            {
                "id": 1,
                "descricao": "Lancamento 03",
                "tipo": "D",
                "valor": 1.0,
                "saldo": -1.0,
                "dataHora": "2023-04-07T06:09:58Z"
            },
            {
                "id": 2,
                "descricao": "Lancamento 03",
                "tipo": "D",
                "valor": 1.0,
                "saldo": -2.0,
                "dataHora": "2023-04-07T06:10:10Z"
            },
            {
                "id": 3,
                "descricao": "Lancamento 03",
                "tipo": "D",
                "valor": 1.0,
                "saldo": -3.0,
                "dataHora": "2023-04-07T06:10:11Z"
            },
            {
                "id": 4,
                "descricao": "Lancamento 03",
                "tipo": "D",
                "valor": 1.0,
                "saldo": -4.0,
                "dataHora": "2023-04-07T06:10:12Z"
            },
            {
                "id": 5,
                "descricao": "Lancamento 03",
                "tipo": "C",
                "valor": 1.0,
                "saldo": -3.0,
                "dataHora": "2023-04-07T06:10:18Z"
            },
            {
                "id": 6,
                "descricao": "Lancamento 03",
                "tipo": "C",
                "valor": 1.0,
                "saldo": -2.0,
                "dataHora": "2023-04-07T06:10:19Z"
            },
            {
                "id": 7,
                "descricao": "Lancamento 03",
                "tipo": "C",
                "valor": 1.0,
                "saldo": -1.0,
                "dataHora": "2023-04-07T06:10:19Z"
            },
            {
                "id": 8,
                "descricao": "Lancamento 03",
                "tipo": "C",
                "valor": 1.0,
                "saldo": 0.0,
                "dataHora": "2023-04-07T06:10:21Z"
            },
            {
                "id": 9,
                "descricao": "Lancamento 03",
                "tipo": "C",
                "valor": 1.0,
                "saldo": 1.0,
                "dataHora": "2023-04-07T06:10:39Z"
            },
            {
                "id": 10,
                "descricao": "Lancamento 03",
                "tipo": "C",
                "valor": 1.0,
                "saldo": 2.0,
                "dataHora": "2023-04-07T06:10:39Z"
            },
            {
                "id": 11,
                "descricao": "Lancamento 03",
                "tipo": "C",
                "valor": 1.0,
                "saldo": 3.0,
                "dataHora": "2023-04-07T06:10:40Z"
            },
            {
                "id": 12,
                "descricao": "Lancamento 03",
                "tipo": "C",
                "valor": 1.0,
                "saldo": 4.0,
                "dataHora": "2023-04-07T06:10:40Z"
            },
            {
                "id": 13,
                "descricao": "Lancamento 03",
                "tipo": "C",
                "valor": 1.0,
                "saldo": 5.0,
                "dataHora": "2023-04-07T06:10:40Z"
            },
            {
                "id": 14,
                "descricao": "Lancamento 03",
                "tipo": "C",
                "valor": 1.0,
                "saldo": 6.0,
                "dataHora": "2023-04-07T06:10:41Z"
            },
            {
                "id": 15,
                "descricao": "Lancamento 03",
                "tipo": "C",
                "valor": 1.0,
                "saldo": 7.0,
                "dataHora": "2023-04-07T06:10:41Z"
            },
            {
                "id": 16,
                "descricao": "Lancamento 03",
                "tipo": "C",
                "valor": 1.0,
                "saldo": 8.0,
                "dataHora": "2023-04-07T06:10:41Z"
            },
            {
                "id": 17,
                "descricao": "Lancamento 03",
                "tipo": "C",
                "valor": 1.0,
                "saldo": 9.0,
                "dataHora": "2023-04-07T06:10:42Z"
            },
            {
                "id": 18,
                "descricao": "Lancamento 03",
                "tipo": "C",
                "valor": 1.0,
                "saldo": 10.0,
                "dataHora": "2023-04-07T06:10:42Z"
            }
        ]
    }