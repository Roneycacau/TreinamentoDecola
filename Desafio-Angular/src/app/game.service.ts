import { Injectable } from "@angular/core";
import { BoardComponent } from "./board/board.component";
import { PlayerComponent } from "./player/player.component";
import { CompileMetadataResolver } from "@angular/compiler";

@Injectable({
  providedIn: "root"
})
export class GameService {
  board: any = ["", "", "", "", "", "", "", "", ""];
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
  win: string[] = [];
  gameOver: boolean = false;
  count: number = 0;
  draw:boolean = false;
  constructor() {}

  play(position): any {
    if (this.gameOver === false) {
      if (this.board[position] === "") {
        this.board[position] = this.player.simbol[this.player.index];
        this.checkWin(this.player.simbol[this.player.index]);
        this.changePlayer();
        if (!this.gameOver) {
          this.count++;
          console.log(this.board);
          if(this.count>=9){
            this.draw = true;
            this.count = 0;
          }
          console.log(this.count);
        }
      }
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
        this.win = this.winningSequences[i];
        console.log(this.win);
        console.log(
          "Sequencia vencedora " + i + "\n Jogador " + player + " venceu!"
        );

        return i;
      }
    }
    return -1;
  }
}
