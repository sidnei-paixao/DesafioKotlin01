import java.time.LocalDateTime

class Matricula(val oAluno: Aluno, val oCurso: Curso)
{
  val dDataMatricula = LocalDateTime.now()
}