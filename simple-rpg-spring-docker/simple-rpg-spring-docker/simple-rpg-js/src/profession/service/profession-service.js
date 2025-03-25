import '../type/types.js'

/**
 * Service for making API calls for professions characters.
 */
export class ProfessionService {

    /**
     * Fetches all professions.
     *
     * @returns {Promise<Professions>} completion promise with professions list
     */
    getProfessions() {
        return fetch('/api/professions')
            .then(response => {
                if (response.ok) {
                    return response.json();
                }
                throw new Error("Network error.");
            });
    }

}
