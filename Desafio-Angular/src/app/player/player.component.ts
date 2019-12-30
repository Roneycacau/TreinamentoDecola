import { Component, OnInit } from "@angular/core";
import { GameService } from "../game.service";
@Component({
  selector: "app-player",
  templateUrl: "./player.component.html",
  styleUrls: ["./player.component.css"]
})
export class PlayerComponent implements OnInit {
  gameService = GameService;
  // player: any = this.gameService.player;
  constructor() {}

  ngOnInit() {}
}
