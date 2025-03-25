import {DataBinder} from '../../../data-binder.js';
import {UserService} from '../../service/user-service.js';
import '../../type/types.js'

window.addEventListener('load', () => {
    new UserListComponent(new DataBinder(), new UserService()).onInit();
});

/**
 * Represents component listing all users.
 */
class UserListComponent {

    /**
     * List of users.
     *
     * @type Users
     */
    users;

    /**
     * Manages state of layout based on data model.
     *
     * @type {DataBinder}
     */
    dataBinder;

    /**
     * User service.
     *
     * @type {UserService}
     */
    userService;

    /**
     * @param {DataBinder} dataBinder manages state of layout based on data model
     * @param {UserService} userService user service
     */
    constructor(dataBinder, userService) {
        this.dataBinder = dataBinder;
        this.userService = userService;
    }

    /**
     * Called when component is initialized.
     */
    onInit() {
        this.userService.getUsers()
            .then(data => {
                this.users = data;
                this.onRender();
            });
    }

    /**
     * Called when component data should be bound to layout.
     */
    onRender() {
        this.dataBinder.render(this, document.getRootNode());
    }

    /**
     * Called when changes in component data should be detected.
     */
    onDetectChanges() {
        this.dataBinder.detectChanges(this, document.getRootNode());
    }

    // noinspection JSUnusedGlobalSymbols
    /**
     * Removes selected user.
     *
     * @param {{id:string, login: string}} user
     */
    onDelete(user) {
        this.userService.deleteUser(user.id)
            .then(() => {
                let index = this.users.users.findIndex(item => item === user);
                if (index > -1) {
                    this.users.users.splice(this.users.users.findIndex(item => item === user), 1);
                    this.onDetectChanges();
                }
            });
    }

}
