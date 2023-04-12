enum class Nivel {
    BASIC, INTERMEDIARY, ADVANCED, EXTREME, ERROR
}

interface FormatNivel{ //Interface que vai tratar a conversão da enumeração.
    //As duas funções da interface são implementadas pelas classes Usuário e Conteúdo Educacional
    fun getNivel():String
    fun formatNivel(nivel: Int):Nivel
}

class Usuario(val nome:String, var apelido:String?, val cpf:String):FormatNivel{
    var nivel:Nivel = Nivel.BASIC
    var isMatriculado:Boolean = false
    fun efetivarMatricula(){
        this.isMatriculado = true
        println("Matrícula Efetivada")
    }fun cancelarMatricula(){
        this.isMatriculado = false
        println("Matricula Cancelada")
    }
    fun newApelido(apelido:String){
        this.apelido = apelido
    }
    override fun getNivel():String{
        when(this.nivel){
            Nivel.BASIC -> return "Básico"
            Nivel.ADVANCED -> return "Avançado"
            Nivel.INTERMEDIARY -> return "Intermediário"
            Nivel.EXTREME -> return "Extremo"
            else -> return "Inválido"
        }
    }

    override fun formatNivel(nivel: Int):Nivel {
        when(nivel){
            0 -> return Nivel.BASIC
            1 -> return Nivel.INTERMEDIARY
            2 -> return Nivel.ADVANCED
            3 -> return Nivel.EXTREME
            else -> return Nivel.ERROR
        }
    }

    fun getUsuario(): String{
        val response: String = "" +
                "==========================\n" +
                "Registro de Usuário:\n" +
                "Nome: ${this.nome}\n" +
                "Apelido: ${this.apelido}\n" +
                "CPF: ${this.cpf}\n" +
                "Nível de Aptidão ${getNivel()}\n" +
                "Matriculado: ${this.isMatriculado}\n"
        return response
    }
}

data class ConteudoEducacional(var nome: String, val nivel: Nivel, val duracao: Int = 60):FormatNivel{
    fun getConteudo():String{
        val response: String = "" +
                "==========================\n" +
                "Registro de Conteúdo:\n" +
                "Nome: ${this.nome}\n" +
                "Apelido: ${this.duracao}\n" +
                "Nivel: ${getNivel()}"
        return response
    }
    override fun getNivel():String{
        when(this.nivel){
            Nivel.BASIC -> return "Básico"
            Nivel.ADVANCED -> return "Avançado"
            Nivel.INTERMEDIARY -> return "Intermediário"
            Nivel.EXTREME -> return "Extremo"
            else -> return "Inválido"
        }
    }
    override fun formatNivel(nivel: Int): Nivel{
        when(nivel){
            0 -> return Nivel.BASIC
            1 -> return Nivel.INTERMEDIARY
            2 -> return Nivel.ADVANCED
            3 -> return Nivel.EXTREME
            else -> return Nivel.ERROR
        }
    }
}

data class Formacao(val nome: String, var conteudos: List<ConteudoEducacional>) {

    var inscritos = mutableListOf<Usuario>()

    fun matricular(usuario: Usuario) { //Adicionar usuários na lista de inscritos
        usuario.efetivarMatricula()
        inscritos.add(usuario)
        //TODO("Utilize o parâmetro $usuario para simular uma matrícula (usar a lista de $inscritos).")
    }
    fun desmatricular(usuario: Usuario){ //Remover usuários da lista de inscritos
        usuario.cancelarMatricula()
        inscritos.remove(usuario)
    }

    fun showUsuarios(){ //Mostrar lista de usuários inscritos com formatação preparada
        for(i in inscritos){
            println(i.getUsuario())
        }
    }
    fun showConteudos(){ //Mostrar lista de conteúdos da formação com formatação preparada
        for(i in conteudos){
            println(i.getConteudo())
        }
    }
    fun showFormacao(): String { //Mostrar o nome da formação e os números de usuários e conteúdos
        val response = "==============================================\n" +
                    "Formação em ${this.nome}\n" +
                    "==============================================\n" +
                    "Número de conteudos: " + conteudos.size + "\n" +
                    "==============================================\n" +
                    "Número de Usuarios: " + inscritos.size + "\n"
        return response
    }
}



fun teste1(){
    val u1 = Usuario("Lukas Jardim", null, "091.078.134-65")
    val u2 = Usuario("Maria Aparecida", "Cida", "023.557.173-21")
    val u3 = Usuario("Jesus Yuki", "Virgem", "420.332.963-77")
    val c1 = ConteudoEducacional("Basic Math", u1.formatNivel(0))
    val c2 = ConteudoEducacional("Limit Calculations", u1.formatNivel(1))
    val c3 = ConteudoEducacional("Derivate Calculations", u1.formatNivel(1))
    val c4 = ConteudoEducacional("Integrate Calculations", u1.formatNivel(2), 120)
    val fCalculo = Formacao("Calculo I", listOf<ConteudoEducacional>(c1, c2, c3, c4))
    fCalculo.matricular(u1)
    fCalculo.matricular(u2)
    fCalculo.matricular(u3)
    fCalculo.showUsuarios()
    fCalculo.showConteudos()
    println(fCalculo.showFormacao())
    fCalculo.desmatricular(u2)
    fCalculo.showUsuarios()
    fCalculo.showConteudos()
    println(fCalculo.showFormacao())

}

fun main() {
    //TODO("Analise as classes modeladas para este domínio de aplicação e pense em formas de evoluí-las.")
    teste1()
    //TODO("Simule alguns cenários de teste. Para isso, crie alguns objetos usando as classes em questão.")
}
/*
Footer
© 2023 GitHub, Inc.
Footer navigation

Terms
Priva
*/