val oDigitalHouse = DHManager()

fun main()
{
  var nOpcao = 0

  do
  {
    println(" ".padStart(50,'-'))
    println("MENU PRINCIPAL".padStart(18,' '))
    println(" ".padStart(50,'-'))
    println("1. Cadastrar um novo curso")
    println("2. Cadastrar um professor")
    println("3. Vincular professores aos cursos")
    println("4. Cadastrar um aluno")
    println("5. Matricular aluno em um curso")
    println("6. Remover um curso")
    println("7. Remover um professor")
    println("0. Finalizar o sistema")
    println(" ".padStart(50,'-'))

    try
    {
      nOpcao = readLine()!!.toInt()
    }
    catch (oErro: NumberFormatException)
    {
      nOpcao = -1
    }
    catch (oErro: Exception)
    {
      println("Houve um erro na operação!\n${oErro.message}\n\n")
      nOpcao = -1
    }


    when(nOpcao)
    {
      0 -> print("Aguarde, finalizando...")
      1 -> fnNovoCurso()
      2 -> fnNovoProfessor()
      3 -> fnVincularProfessor()
      4 -> fnCadastrarAluno()
      5 -> fnMatricular()
      6 -> fnExcluirCurso()
      7 -> fnExcluirProfessor()
      else -> println("Opção selecionada inválida. Tente novamente, com uma opção válida...\n\n\n")
    }
  } while (nOpcao != 0)

}

private fun fnNovoCurso()
{
  println("Oba! Um novo curso!\nPrecisamos de alguns dados para continuar...\n")

  try
  {
    print("Qual o código do curso? ")
    val nCurso = readLine()!!.toInt()
    print("E o nome dele? ")
    val cNome = readLine()!!.toString()
    print("Quantos alunos poderão estudar nesta sala? ")
    val nQtde = readLine()!!.toInt()
    oDigitalHouse.fnRegistrarCurso(nCurso, cNome, nQtde)
    println("Curso cadastrado! Pressione <ENTRA> para continuar...")
    readLine()
  }
  catch (oErro: Exception)
  {
    println("Ops... houve um erro e o curso não foi cadastrado!\n${oErro.message}\n\nPressione <ENTRA> para continuar...")
    readLine()
  }
}

private fun fnNovoProfessor()
{
  println("Novo funcionário?\nPrecisamos de mais dados para dar-lhe as boas vindas...\n")

  try
  {
    print("Qual o número de registro deste professor? ")
    val nProfessor = readLine()!!.toInt()
    print("E o nome dele? ")
    val cNome = readLine()!!.toString()
    print("Agora, qual o sobrenome? ")
    val cSobrenome = readLine()!!.toString()
    print("Estamos quase lá... Ele é um professor TITULAR (\"S\" para SIM, qualquer outra tecla para NÃO)? ")
    val cOpcao = readLine()!!.toString().toUpperCase()

    if(cOpcao=="S")
    {
      print("Ótimo! Qual a especialidade deste professor? ")
      val cEspecialidade = readLine()!!.toString()
      oDigitalHouse.fnRegistrarProfTitular(nProfessor, cNome, cSobrenome, cEspecialidade)
    }
    else
    {
      print("Ótimo! Quantas horas de monitoria ele possui? ")
      val nHoras = readLine()!!.toInt()
      oDigitalHouse.fnRegistrarProfAdjunto(nProfessor, cNome, cSobrenome, nHoras)
    }

    println("Mais um profissional na casa! Pressione <ENTRA> para continuar...")
    readLine()
  }
  catch (oErro: Exception)
  {
    println("Ops... houve um erro e o professor não foi cadastrado!\n${oErro.message}\n\nPressione <ENTRA> para continuar...")
    readLine()
  }
}

private fun fnVincularProfessor()
{
  println("Que bom!\nVamos fazer um curso funcionar?\n")

  try
  {
    print("Qual o código (registro) do professor titular? ")
    val nTitular = readLine()!!.toInt()
    print("Qual o código (registro) do professor adjunto? ")
    val nAdjunto = readLine()!!.toInt()
    print("E por último, em qual curso eles serão vinculados? ")
    val nCurso = readLine()!!.toInt()

    oDigitalHouse.fnAlocarProfessores(nCurso, nTitular, nAdjunto)
    println("Pressione <ENTRA> para continuar...")
    readLine()
  }
  catch (oErro: Exception)
  {
    println("Ops... houve um erro e o professor não foi vinculado!\n${oErro.message}\n\nPressione <ENTRA> para continuar...")
    readLine()
  }
}

private fun fnCadastrarAluno()
{
  println("Lá vem DIN DIN!\nEssa é a alma do nosso negócio (os alunos, não o dinheiro...)\n")

  try
  {
    print("Qual o número de matrícula do aluno? ")
    val nAluno = readLine()!!.toInt()
    print("E o nome dele? ")
    val cNome = readLine()!!.toString()
    print("Agora, qual o sobrenome? ")
    val cSobrenome = readLine()!!.toString()

    oDigitalHouse.fnRegistrarAluno(nAluno, cNome, cSobrenome)
    println("Aluno cadastrado! Pressione <ENTRA> para continuar...")
    readLine()
  }
  catch (oErro: Exception)
  {
    println("Ops... houve um erro e o aluno não foi cadastrado!\n${oErro.message}\n\nPressione <ENTRA> para continuar...")
    readLine()
  }

}

private fun fnMatricular()
{
  println("É isso aí!\nTodo mundo estudando!\n")

  try
  {
    print("Qual a matrícula do aluno? ")
    val nAluno = readLine()!!.toInt()
    print("Qual o código do curso? ")
    val nCurso = readLine()!!.toInt()

    oDigitalHouse.fnMatricularAluno(nAluno, nCurso)
    println("Pressione <ENTRA> para continuar...")
    readLine()
  }
  catch (oErro: Exception)
  {
    println("Ops... houve um erro e o aluno não foi matriculado!\n${oErro.message}\n\nPressione <ENTRA> para continuar...")
    readLine()
  }
}

private fun fnExcluirCurso()
{
  println("Ah, que pena!\nTodo mundo gostava deste curso...\n")

  try
  {
    print("Qual o código do curso? ")
    val nCurso = readLine()!!.toInt()
    println("Você quer mesmo excluir este curso? Confirme esta ação digitando \"EXCLUIR\" abaixo (qualquer outra coisa cancelará a operação):")
    val cOpcao = readLine()!!.toString().toUpperCase()

    if(cOpcao=="EXCLUIR")
    {
      oDigitalHouse.fnExcluirCurso(nCurso)
      println("Agora, já foi... curso excluído. Pressione <ENTRA> para continuar...")
    }
    else
      println("Que bom que você mudou de ideia! Pressione <ENTRA> para continuar...")

    readLine()
  }
  catch (oErro: Exception)
  {
    println("Ops... houve um erro e o curso não foi removido!\n${oErro.message}\n\nPressione <ENTRA> para continuar...")
    readLine()
  }
}

private fun fnExcluirProfessor()
{
  println("Eita!\nEle fez algo errado?\n")

  try
  {
    print("Qual o código (registro) do professor? ")
    val nProfessor = readLine()!!.toInt()
    println("Você quer mesmo excluir este professor? Confirme esta ação digitando \"EXCLUIR\" abaixo (qualquer outra coisa cancelará a operação):")
    val cOpcao = readLine()!!.toString().toUpperCase()

    if(cOpcao=="EXCLUIR")
    {
      oDigitalHouse.fnExcluirProfessor(nProfessor)
      println("O professor foi excluído. Pressione <ENTRA> para continuar...")
    }
    else
      println("Que bom que você mudou de ideia! Pressione <ENTRA> para continuar...")

    readLine()
  }
  catch (oErro: Exception)
  {
    println("Ops... houve um erro e o professor não foi removido!\n${oErro.message}\n\nPressione <ENTRA> para continuar...")
    readLine()
  }
}