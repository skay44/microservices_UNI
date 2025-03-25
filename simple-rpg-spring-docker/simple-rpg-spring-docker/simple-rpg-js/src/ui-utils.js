/**
 * Utility component for UI related code.
 */
export class UiUtils {

    /**
     * Initialize MDB input controls. Required in order to display floating labels correctly.
     */
    initInputs() {
        document.querySelectorAll('.form-outline').forEach((formOutline) => {
            new mdb.Input(formOutline).init();// Variable not imported into module but will be visible in JS engine.
        });
    }

}
