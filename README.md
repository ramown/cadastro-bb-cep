# cadastro-bb-cep


#Descrição

Através do uso de APIs extenas, [Breaking Bad API](https://www.breakingbadapi.com/api/) e [ViaCep](https://viacep.com.br/) foi criado um sistema de cadastro de usuários,
que busca na primeira API citada as referência de um determinado personagem, usando o nome do personagem.
Seguido de uma busca de um endereço no ViaCep usando um Cep passado como parametro no corpo de uma requisição.

As consultadas que podem ser realizadas são as seguintes:

- **Listar todos os usuários** (GET)
```
http://localhost:8080/usuarios/
```

- **Listar usuário por id** (GET)
```
http://localhost:8080/usuarios/{id}
```

- **Cadastrar um usuário** (POST)
```
http://localhost:8080/usuarios/
```

> Corpo da requisição

```
{
    "nome": "Walter White",
    "cep": "01001000",
    "email": "example@email.com"
}
```

- **Exceções usadas** (Retorna uma messagem de erro personalizada)

  - EntityNotFoundException: Caso não encontre o endereço no [ViaCep](https://viacep.com.br/) ou não encontre o personagem no [breakingbadapi](https://www.breakingbadapi.com/api/). **Status code=404**
  - EntityAlreadysExists: Caso tente cadastrar um email que já se encontra no banco de dados. **Status code=400**
