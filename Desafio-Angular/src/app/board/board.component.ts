import { Component, OnInit } from "@angular/core";
import { GameService } from "../game.service";

@Component({
  selector: "app-board",
  templateUrl: "./board.component.html",
  styleUrls: ["./board.component.css"]
})
export class BoardComponent implements OnInit {
  board = this.gameService.board;
  constructor(private gameService: GameService) {
    // this.gameService = new GameService();
  }

  ngOnInit() {
    this.play("");
  }

  play(position): any {
    this.gameService.play(position);
  }

  restart() {
    this.gameService.board.fill("");
    this.gameService.gameOver = false;
    this.gameService.player.index = 0;
    this.gameService.win = [];
    console.log("resetou");
  }
}
