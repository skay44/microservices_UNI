import { Profession } from "../../profession/model/profession";

/**
 * Represents single character in list.
 */
export interface CharacterDetails {

  /**
   * Unique id identifying character.
   */
  id: string;

  /**
   * Name of the character.
   */
  name: string;

  /**
   * Character's background story.
   */
  background: string;

  /**
   * Character's age.
   */
  age: number;

  /**
   * Character's strength.
   */
  strength: number;

  /**
   * Character's constitution.
   */
  constitution: number;

  /**
   * Character's charisma.
   */
  charisma: number;

  /**
   * Character's health.
   */
  health: number;

  /**
   * Character's level.
   */
  level: number;

  /**
   * Character's total experience.
   */
  experience: number;

  /**
   * Character's profession.
   */
  profession: Profession;

}
