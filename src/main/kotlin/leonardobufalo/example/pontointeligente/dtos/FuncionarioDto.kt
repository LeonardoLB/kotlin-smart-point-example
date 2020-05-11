package leonardobufalo.example.pontointeligente.dtos

import org.hibernate.validator.constraints.Length
import javax.validation.constraints.Email
import javax.validation.constraints.NotEmpty

data class FuncionarioDto (

        @get:NotEmpty(message = "Não pode vir vazio")
        @get:Length(min = 3, max = 200, message = "Precisa ter entre 3 a 200 caracteres")
        val nome: String = "",

        @get:NotEmpty(message = "Não pode vir vazio")
        @get:Length(min = 5, max = 200, message = "Precisa ter entre 5 a 200 caracteres")
        @get:Email(message = "email invalido")
        val email: String = "",

        val senha: String? = null,
        val valorHora: String? = null,
        val qtdHorasTrabalhoDia: String? = null,
        val qtdHorasAlmoco: String? = null,
        val id: String? = null

)