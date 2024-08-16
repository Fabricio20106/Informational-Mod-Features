# Command Block Logic

**Command block logic** is what **command blocks** and **minecarts with command blocks** use to perform, save and write their command data.

This class extends *ICommandSource*, a class which defines various things needed to run commands.

## Performing the command
When this command block is run, the `performCommand(World)` boolean method is executed.

Before anything else, the method checks if the World is on the server-side, and its last execution wasn't on the same tick. If these two things are true, this is roughly what happens:

1. If the input is `Searge` (case-insentitive), the success count will be set to `1`, and its output to `#itzlipofutzli`;
2. If it's not the case, the success count it set back to `0`, and then it checks if the server allows command blocks, and if the command isn't null or empty;
3. If true, the last execution is set to null, and the command attempts to be run, creating its *CommandSource*;
4. If in this process it fails in any way, a new **crash report** is thrown. The crash report will have an *"Executing command block"* category, with the following fields:
    - *"Command"*: The command being executed;
    - *"Name"*: The name of this command block, being `@` by default.
5. If **Step 2.** is false, and updating the last execution is allowed, it will set the last execution tick to the current tick, and if not, it will be set to `-1`.

## Extra methods
These are some extra functional methods inside this class:

### → `sendMessage(ITextComponent, UUID)`
This method sets the last execution to a formatted string with the intented output: `[HH:mm:ss] <the provided ITextComponent>`, and runs the `onUpdated()` method.

### → `usedBy(PlayerEntity)`
This method returns the *ActionResultType* for when the player interacts with this block. First, it checks if the player is a level 2 operator, and if they're in creative mode, and it *passes* if that's true.

If not, it checks if the player's world is on the client-side, and opens the command block minecart GUI, *succeding* if the world is client-side, and *consumes* otherwise.

### → `acceptsSuccess()`
Returns `true` if the `sendCommandFeedback` gamerule is true, and if this command block tracks it output.

Controls whether this command block will show its command's success message on the command block GUI.

### → `acceptsFailure()`
Returns `true` if this command block tracks its output.

Controls whether this command block will show its command's fail message on the command block GUI.

### → `shouldInformAdmins()`
Returns `true` if the `commandBlockOutput` gamerule is true.

This controls whether this command block will send its output to the chat of all server operators.

## Data format
- `Command`: **[String]** The command stored inside this command block;
- `SuccessCount`: **[Integer]** How many commands were successfully run in this command block. Normally, this value doesn't go above 1;
- `CustomName`: **[String; Text Component]** This command block's name. This is `@` by default.
- `TrackOutput`: **[Boolean]** Whether this command block saves its last output or not.
- `LastOutput`: **[String; Text Component; Optional]** The last output by this command block. Only saved if `TrackOutput` is true.
- `UpdateLastExecution`: **[Boolean]** Whether this command block saves when its last execution was.
- `LastExecution`: **[Long; Optional]** The tick when this command block was last executed.