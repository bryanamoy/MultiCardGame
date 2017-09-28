package edu.buffalo.cse116;

/**
* <h1>Card Class<h1>
* Each Card instance is a combination of suite & rank.
* <p>
* @author Corey Almonte
* @version 0.5
* @since 2017-09-27
*/
public class Card {
/**
 * Make it so that can get and set both instances for suite and rank.
 */

  private Suite suite;
  private Rank rank;

  public Card(Suite suite, Rank rank) {
    this.suite = suite;
    this.rank = rank;
  }
}
