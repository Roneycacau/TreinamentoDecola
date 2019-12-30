import { Component, OnInit } from "@angular/core";

@Component({
  selector: "app-game",
  templateUrl: "./game.component.html",
  styleUrls: ["./game.component.css"]
})
export class GameComponent implements OnInit {
  board: string[] = ["", "", "", "", "", "", "", "", ""];
  player: any = {
    simbol: ["X", "O"],
    index: 0
  };
  winningSequences: any[][] = [
    [0, 1, 2],
    [3, 4, 5],
    [6, 7, 8],
    [0, 3, 6],
    [1, 4, 7],
    [2, 5, 8],
    [0, 4, 8],
    [2, 4, 6]
  ];

  gameOver: boolean = false;
  win: boolean = false;

  constructor() {}

  ngOnInit() {}

  play(position) {
    if (this.gameOver === false) {
      if (this.board[position] === "") {
        this.board[position] = this.player.simbol[this.player.index];
        this.checkWin(this.player.simbol[this.player.index]);
        this.changePlayer();
      }
      console.log(this.board);
    }
  }
  changePlayer() {
    this.player.index = this.player.index === 0 ? 1 : 0;
  }
  checkWin(player) {
    for (let i in this.winningSequences) {
      if (
        this.board[this.winningSequences[i][0]] == player &&
        this.board[this.winningSequences[i][1]] == player &&
        this.board[this.winningSequences[i][2]] == player
      ) {
        this.gameOver = true;
        this.win = true;
        console.log(
          "Sequencia vencedora " + i + "\n Jogador " + player + " venceu!"
        );

        return i;
      }
    }
    return -1;
  }

  restart() {
    this.board.fill("");
    this.gameOver = false;
    this.player.index = 0;
  }
}
