import '../type/types.js'

/**
 * Service for making API calls for users management.
 */
export class UserService {

    /**
     * Fetches all users.
     *
     * @returns {Promise<Users>} completion promise with users list
     */
    getUsers() {
        return fetch('/api/users')
            .then(response => {
                if (response.ok) {
                    return response.json();
                }
                throw new Error("Network error.");
            });
    }

    /**
     * Removes single user.
     *
     * @param {string} id user id
     * @returns {Promise} completion promise
     */
    deleteUser(id) {
        return fetch('/api/users/' + id, {
            method: 'DELETE'
        })
            .then(response => {
                if (response.ok) {
                    return;
                }
                throw new Error("Network error.");
            });
    }

}
