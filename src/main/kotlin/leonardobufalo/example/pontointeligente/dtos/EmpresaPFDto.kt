package leonardobufalo.example.pontointeligente.dtos

import org.hibernate.validator.constraints.Length
import org.hibernate.validator.constraints.br.CPF
import javax.validation.constraints.Email
import javax.validation.constraints.NotEmpty

data class EmpresaPFDto (

        @get:NotEmpty(message = "nome não pode ser vazio")
        @get:Length(min = 3, max = 200, message = "Nome deve conter entre 3 e 200 caracteres")
        val nome: String = "",

        @get:NotEmpty(message = "Email não pode ser")
        @get:Length(min = 3, max = 200, message = "Email deve ter entre 3 a 200 caracteres")
        @get:Email(message = "Email Invalido")
        val email: String = "",

        @get:NotEmpty(message = "Senha não pode ser vazia")
        val senha: String = "",

        @get:NotEmpty(message = "Cpf não pode ser vazia")
        @get:CPF(message = "CPF invalido")
        val cpf: String = "",

        @get:NotEmpty(message = "CNPJ não pode ser vazia")
        @get:CPF(message = "CNPJ invalido")
        val cnpj: String = "",

        val empresaId: String? = null,

        val valorHora: String? = null,
        val qtdHorasTrabalhoDia: String? = null,
        val qtdHorasAlmoco: String? = null,
        val id: String? = null
)