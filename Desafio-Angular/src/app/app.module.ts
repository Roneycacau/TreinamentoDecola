import { BrowserModule } from "@angular/platform-browser";
import { NgModule } from "@angular/core";

import { AppRoutingModule } from "./app-routing.module";
import { AppComponent } from "./app.component";
import { GameComponent } from "./game/game.component";
import { PlayerComponent } from './player/player.component';
import { BoardComponent } from './board/board.component';

@NgModule({
  declarations: [AppComponent, GameComponent, PlayerComponent, BoardComponent],
  imports: [BrowserModule, AppRoutingModule],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule {}
