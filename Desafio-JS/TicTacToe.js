const game = {
  board: ['', '', '', '', '', '', '', '', ''],
  winnerSequences: [
    [0, 1, 2],
    [3, 4, 5],
    [6, 7, 8],
    [0, 3, 6],
    [1, 4, 7],
    [2, 5, 8],
    [0, 4, 8],
    [2, 4, 6]
  ],
  players: {
    options: ['X', 'O'],
    index: 0,
    change: function() {
      this.index = this.index === 0 ? 1 : 0;
    }
  },
  container_element: null,
  gameOver: false,

  init: function(container) {
    this.container_element = container;
  },

  play: function(position) {
    if (this.gameOver) {
      return false;
    }
    if (this.board[position] === '') {
      this.board[position] = this.players.options[this.players.index];
      this.draw();
      let win = this.checkWin(this.players.options[this.players.index]);
      if (win >= 0) {
        this.endGame();
        this.stylize_winner_sequence(this.winnerSequences[win]);
      } else {
        this.players.change();
      }
      return true;
    } else {
      return false;
    }
  },
  startGame: function() {
    this.board.fill('');
    this.draw();
    this.gameOver = false;
  },
  stylize_winner_sequence(winner_sequence) {
    winner_sequence.forEach(position => {
      this.container_element
        .querySelector(`div:nth-child(${position + 1})`)
        .classList.add('winner');
    });
  },

  endGame: function() {
    this.gameOver = true;
    console.log('ACABOU');
  },
  checkWin: function(player) {
    for (i in this.winnerSequences) {
      if (
        this.board[this.winnerSequences[i][0]] == player &&
        this.board[this.winnerSequences[i][1]] == player &&
        this.board[this.winnerSequences[i][2]] == player
      ) {
        console.log('Sequencia vencedora ' + i);
        return i;
      }
    }
    return -1;
  },

  draw: function() {
    let content = '';
    for (i in this.board) {
      content +=
        '<div onclick="game.play(' + i + ')">' + this.board[i] + '</div>';
    }
    this.container_element.innerHTML = content;
  }
};
