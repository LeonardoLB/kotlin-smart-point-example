package leonardobufalo.example.pontointeligente.documents

import leonardobufalo.example.pontointeligente.enums.TipoEnum
import java.util.*

data class Lancamento(
        val date: Date,
        val tipo: TipoEnum,
        val funcionarioId: String,
        val descricao: String? = "",
        val localizacao: String? = ""
)
