import java.awt.image.ByteLookupTable

fun createTable(): Array<Array<Char>> {
    val table: Array<Array<Char>> = arrayOf(
        arrayOf(' ', '1', '2', '3'),
        arrayOf('1', '-', '-', '-'),
        arrayOf('2', '-', '-', '-'),
        arrayOf('3', '-', '-', '-')
    )
    for (row in table){
        for (col in row){
            print("$col ")
        }
        println()
    }
    return table
}
fun UpdateTable(rc: Array<Int>, player: Char, table: Array<Array<Char>>) {
    table[rc.get(0)][rc.get(1)] = player;
    for (row in table){
        for (col in row){
            print("$col ")
        }
        println()
    }
}

fun InputRC(table: Array<Array<Char>>): Array<Int> {
    while (true){
        try {
            print("Please input Row Col : ")
            val input = readLine()
            val inputArr = input?.split(' ')

            if (inputArr?.size != 2){
                println("Error...size!!")
                continue
            }
            val rowInd = inputArr.get(0).toInt()
            val colInd = inputArr.get(1).toInt()
            if (rowInd > 3 || rowInd < 1 || colInd > 3 || colInd < 2){
                println("Error...number!!!")
                continue
            }
            if (table[rowInd][colInd] != '-'){
                println("Repeat position!! Please EnTer a new....")
                continue
            }
            val Arriuput = arrayOf(rowInd,colInd)
            return Arriuput
            break
        }catch (t: Throwable){
            println("Error....type")
        }
    }
}
fun switched(player: Char): Char {
    if (player == 'O'){
        println("Turn play : X")
        return 'X'
    }else{
        println("Turn play : O")
        return 'O'
    }
}

fun checkWin(table: Array<Array<Char>>, player: Char): Boolean {
    var sum = 0
    var win = false
    // row winner
    for (row in 0 until 4){
        for (col in 0 until 4){
            if (table[row][col] == player)
                sum++
            if (sum == 3)
                win = true
        }
        sum = 0
    }
    //Col winner
    for (row in 0 until 4){
        for (col in 0 until 4){
            if (table[col][row] == player)
                sum++
            if (sum == 3)
                win = true
        }
        sum = 0
    }
    if (table[1][1] == player && table[2][2] == player && table[3][3] == player )
        win == true
    if (table[3][1] == player && table[2][2] == player && table[1][3] == player )
        win == true
    return win
}

fun main(){
    var player = 'O'
    var rc: Array<Int>
    var table = createTable()
    var turn = 0

    while (turn < 9) {
        player = switched(player)
        rc = InputRC(table)
        UpdateTable(rc,player,table)
        if (checkWin(table,player)){
            println("GAME OVER!! PLAYER ${player} WIN")
            break
        }
        turn++
    }
    if (turn == 9)
    print("GAME OVER!! DRAW")
}
