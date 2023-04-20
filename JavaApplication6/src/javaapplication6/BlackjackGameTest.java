import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BlackjackGameTest {

  private BlackjackGame game;
  
  @BeforeEach
  void setUp() {
    game = new BlackjackGame();
    game.deal();
  }
  
  @Test
  void testDeal() {
    assertEquals(2, game.getPlayerCards().size());
    assertEquals(2, game.getDealerCards().size());
    assertEquals(48, game.getDeck().size());
  }
  
  @Test
  void testPlayerScore() {
    assertEquals(0, game.getPlayerScore());
    game.getPlayerCards().add(new Card(Rank.ACE, Suit.HEARTS));
    assertEquals(1, game.getPlayerScore());
    game.getPlayerCards().add(new Card(Rank.TEN, Suit.CLUBS));
    assertEquals(11, game.getPlayerScore());
    game.getPlayerCards().add(new Card(Rank.KING, Suit.SPADES));
    assertEquals(21, game.getPlayerScore());
  }
  
  @Test
  void testDealerScore() {
    assertEquals(0, game.getDealerScore());
    game.getDealerCards().add(new Card(Rank.SEVEN, Suit.HEARTS));
    assertEquals(7, game.getDealerScore());
    game.getDealerCards().add(new Card(Rank.TEN, Suit.DIAMONDS));
    assertEquals(17, game.getDealerScore());
    game.getDealerCards().add(new Card(Rank.ACE, Suit.CLUBS));
    assertEquals(18, game.getDealerScore());
  }
  
  @Test
  void testPlayerHit() {
    game.playerHit();
    assertEquals(3, game.getPlayerCards().size());
    assertEquals(47, game.getDeck().size());
  }
  
  @Test
  void testDealerHit() {
    game.dealerHit();
    assertTrue(game.getDealerScore() >= 17);
    assertTrue(game.getDealerScore() <= 21);
    assertTrue(game.getDeck().size() <= 44);
  }
  
  @Test
  void testIsPlayerBust() {
    game.getPlayerCards().add(new Card(Rank.KING, Suit.DIAMONDS));
    game.getPlayerCards().add(new Card(Rank.QUEEN, Suit.CLUBS));
    assertTrue(game.isPlayerBust());
  }
  
  @Test
  void testIsDealerBust() {
    game.getDealerCards().add(new Card(Rank.TEN, Suit.DIAMONDS));
    game.getDealerCards().add(new Card(Rank.SEVEN, Suit.CLUBS));
    game.getDealerCards().add(new Card(Rank.FOUR, Suit.SPADES));
    assertTrue(game.isDealerBust());
  }
  
  @Test
  void testIsPlayerWin() {
    game.getPlayerCards().clear();
    game.getPlayerCards().add(new Card(Rank.TEN, Suit.HEARTS));
    game.getPlayerCards().add(new Card(Rank.QUEEN, Suit.DIAMONDS));
    game.getDealerCards().clear();
    game.getDealerCards().add(new Card(Rank.TEN, Suit.CLUBS));
    game.getDealerCards().add(new Card(Rank.TEN, Suit.SPADES));
    assertTrue(game.isPlayerWin());
  }
  
  @Test
  void testIsDealerWin() {
    game.getPlayerCards().clear();
    game.getPlayerCards().add(new Card(Rank.TEN, Suit.HEARTS));
    game.getPlayerCards().add(new Card(Rank.SEVEN, Suit.DIAMONDS));
    game.getDealerCards().clear();
  }