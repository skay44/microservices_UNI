import { Character } from "./character";

/**
 * GET characters response. Contains list of available characters. Can be used to list particular user's characters as
 * well as all characters in the game.
 */
export interface Characters {

  /**
   * Name of the selected characters.
   */
  characters:Character[];

}
