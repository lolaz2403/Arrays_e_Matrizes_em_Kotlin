fun main() {
    var opcao: Int?

    do {
        println("\n==========================================")
        println("   LISTA DE EXERCÍCIOS - ARRAYS E MATRIZES")
        println("==========================================")
        println("1  - Inversão de Vetor (while)")
        println("2  - Busca e Interrupção (break)")
        println("3  - Média de Temperaturas")
        println("4  - Filtragem de Índices Pares (step 2)")
        println("5  - Listagem de Tarefas (.withIndex)")
        println("6  - Soma por Linhas (Matriz 3x4)")
        println("7  - Matriz Transposta (2x3 -> 3x2)")
        println("8  - Soma da Diagonal Principal (Matriz 4x4)")
        println("9  - Ignorar Zeros na Matriz (continue)")
        println("10 - Boletim de Alunos (Matriz 3x2)")
        println("0  - Sair")
        print("\nEscolha uma questão para executar: ")

        opcao = readlnOrNull()?.trim()?.toIntOrNull()
        println()

        when (opcao) {
            1 -> questao01()
            2 -> questao02()
            3 -> questao03()
            4 -> questao04()
            5 -> questao05()
            6 -> questao06()
            7 -> questao07()
            8 -> questao08()
            9 -> questao09()
            10 -> questao10()
            0 -> println("Encerrando o programa...")
            else -> println("Opção inválida! Digite um número entre 0 e 10.")
        }
    } while (opcao != 0)
}

// ==========================================
// BLOCO I: ARRAYS UNIDIMENSIONAIS
// ==========================================

fun questao01() {
    val numeros = intArrayOf(10, 20, 30, 40, 50, 60)
    println("Original:  ${numeros.contentToString()}")

    var inicio = 0
    var fim = numeros.size - 1

    while (inicio < fim) {
        val temp = numeros[inicio]
        numeros[inicio] = numeros[fim]
        numeros[fim] = temp

        inicio++
        fim--
    }

    println("Invertido: ${numeros.contentToString()}")
}

fun questao02() {
    val codigosTransacao = arrayOf("TX-901", "TX-450", "TX-772", "TX-118", "TX-309")
    val codigoBuscado = "TX-772"
    var encontrado = false

    for (indice in codigosTransacao.indices) {
        if (codigosTransacao[indice] == codigoBuscado) {
            println("Código '$codigoBuscado' encontrado no índice $indice (posição ${indice + 1}).")
            encontrado = true
            break
        }
    }

    if (!encontrado) {
        println("Código '$codigoBuscado' não localizado.")
    }
}

fun questao03() {
    val temperaturas = doubleArrayOf(28.5, 31.0, 29.2, 33.4, 32.8, 27.9, 30.1)
    var soma = 0.0

    for (temp in temperaturas) {
        soma += temp
    }

    val media = soma / temperaturas.size
    println("Média de temperatura da semana: ${"%.2f".format(media)}°C")
    println("Dias (índices) com temperatura acima da média:")

    for (dia in temperaturas.indices) {
        if (temperaturas[dia] > media) {
            println("- Índice $dia: ${temperaturas[dia]}°C")
        }
    }
}

fun questao04() {
    val numeros = IntArray(20) { it + 1 }
    var somaIndicesPares = 0

    print("Valores nos índices pares: ")
    for (indice in numeros.indices step 2) {
        print("${numeros[indice]} ")
        somaIndicesPares += numeros[indice]
    }

    println("\nSoma total dos valores em índices pares: $somaIndicesPares")
}

fun questao05() {
    val tarefas = arrayOf(
        "Sincronizar banco de dados local",
        "Validar token de autenticação",
        "Carregar catálogo de produtos",
        "Atualizar status dos pedidos"
    )

    for ((indice, descricao) in tarefas.withIndex()) {
        println("Tarefa ${indice + 1}: $descricao")
    }
}

// ==========================================
// BLOCO II: MATRIZES BIDIMENSIONAIS
// ==========================================

fun questao06() {
    val matriz = arrayOf(
        intArrayOf(4, 8, 2, 6),
        intArrayOf(10, 5, 15, 0),
        intArrayOf(3, 7, 9, 1)
    )

    for (linha in matriz.indices) {
        var somaLinha = 0
        for (coluna in matriz[linha].indices) {
            somaLinha += matriz[linha][coluna]
        }
        println("Soma da Linha $linha: $somaLinha")
    }
}

fun questao07() {
    val original = arrayOf(
        intArrayOf(1, 2, 3),
        intArrayOf(4, 5, 6)
    )

    val linhasOrig = original.size
    val colunasOrig = original[0].size
    val transposta = Array(colunasOrig) { IntArray(linhasOrig) }

    for (i in 0 until linhasOrig) {
        for (j in 0 until colunasOrig) {
            transposta[j][i] = original[i][j]
        }
    }

    println("Matriz Original (2x3):")
    for (linha in original) {
        println(linha.contentToString())
    }

    println("\nMatriz Transposta (3x2):")
    for (linha in transposta) {
        println(linha.contentToString())
    }
}

fun questao08() {
    val matriz = arrayOf(
        intArrayOf(5, 1, 2, 3),
        intArrayOf(4, 10, 6, 7),
        intArrayOf(8, 9, 15, 11),
        intArrayOf(12, 13, 14, 20)
    )

    var somaDiagonalPrincipal = 0

    println("Matriz 4x4:")
    for (linha in matriz.indices) {
        for (coluna in matriz[linha].indices) {
            print("${matriz[linha][coluna]}\t")
            if (linha == coluna) {
                somaDiagonalPrincipal += matriz[linha][coluna]
            }
        }
        println()
    }

    println("\nSoma da Diagonal Principal: $somaDiagonalPrincipal")
}

fun questao09() {
    val matriz = arrayOf(
        intArrayOf(12, 0, 7),
        intArrayOf(0, 25, 0),
        intArrayOf(3, 0, 18)
    )

    var somaMaioresQueZero = 0

    for (linha in matriz.indices) {
        for (coluna in matriz[linha].indices) {
            val valor = matriz[linha][coluna]
            if (valor == 0) {
                continue
            }
            if (valor > 0) {
                somaMaioresQueZero += valor
            }
        }
    }

    println("Soma dos valores maiores que zero: $somaMaioresQueZero")
}

fun questao10() {
    val boletim = Array(3) { DoubleArray(2) }

    boletim[0] = doubleArrayOf(8.5, 7.5)
    boletim[1] = doubleArrayOf(6.0, 5.5)
    boletim[2] = doubleArrayOf(9.0, 9.5)

    var somaMediasTurma = 0.0

    for (aluno in boletim.indices) {
        var somaNotasAluno = 0.0
        for (nota in boletim[aluno]) {
            somaNotasAluno += nota
        }

        val mediaAluno = somaNotasAluno / boletim[aluno].size
        somaMediasTurma += mediaAluno

        val status = if (mediaAluno >= 7.0) "Aprovado" else "Reprovado"
        println("Aluno ${aluno + 1} | Média: ${"%.2f".format(mediaAluno)} | Situação: $status")
    }

    val mediaGeralTurma = somaMediasTurma / boletim.size
    println("-----------------------------------------")
    println("Média Geral da Turma: ${"%.2f".format(mediaGeralTurma)}")
}