import { Component, OnInit } from '@angular/core';
import { CharacterService } from '../../service/character.service';
import { ActivatedRoute, Router } from '@angular/router';
import { CharacterForm } from '../../model/character-form';
import { ProfessionService } from "../../../profession/service/profession.service";
import { Professions } from "../../../profession/model/professions";

@Component({
  selector: 'app-character-edit',
  templateUrl: './character-edit.component.html',
  styleUrls: ['./character-edit.component.css']
})
export class CharacterEditComponent implements OnInit {

  /**
   * Character's id.
   */
  uuid: string | undefined;

  /**
   * Single character.
   */
  character: CharacterForm | undefined;

  /**
   * Single character.
   */
  original: CharacterForm | undefined;

  /**
   * Available professions.
   */
  professions: Professions | undefined;

  /**
   * @param characterService character service
   * @param professionService profession service
   * @param route activated route
   * @param router router
   */
  constructor(
    private characterService: CharacterService,
    private professionService: ProfessionService,
    private route: ActivatedRoute,
    private router: Router
  ) {
  }

  ngOnInit() {
    this.route.params.subscribe(params => {
      this.professionService.getProfessions()
        .subscribe(professions => this.professions = professions);

      this.characterService.getCharacter(params['uuid'])
        .subscribe(character => {
          this.uuid = character.id;
          this.character = {
            name: character.name,
            background: character.background,
            age: character.age,
            charisma: character.charisma,
            constitution: character.constitution,
            strength: character.strength,
            profession: character.profession.id
          };
          this.original = {...this.character};
        });
    });
  }

  /**
   * Updates character.
   */
  onSubmit(): void {
    this.characterService.putCharacter(this.uuid!, this.character!)
      .subscribe(() => this.router.navigate(['/characters']));
  }

}
