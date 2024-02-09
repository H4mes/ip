public class DeleteCommand extends Command {
    protected int index;

    /**
     * Constructs new DeleteCommand object with a specified index of the task to be deleted.
     *
     * @param index the 1-indexed number of the task to be deleted when executed
     */
    public DeleteCommand(int index) {
        this.index = index;
    }

    /**
     * Method that deletes the task from the current task list within the program and on the hard disk.
     *
     * @param tasks The TaskList object on which the command will operate
     * @param storage The Storage object that will read and write to files
     * @param ui The Ui object that handles displaying messages
     */
    @Override
    public void execute(TaskList tasks, Storage storage, Ui ui) {
        super.tasks = tasks;
        super.storage = storage;
        super.ui = ui;
        String tempTask = super.tasks.printTask(index);
        super.tasks.deleteTask(index);
        super.storage.saveTaskListToFile(super.tasks.getTasks());
        String message = "As ye command, this one has walked the plank:\n"
                + tempTask + "\nOnly "
                +  super.tasks.getTaskCount() + " tasks remain, captain!";
        super.ui.printMessage(message);
    }
}
