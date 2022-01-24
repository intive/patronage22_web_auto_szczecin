### The aim of this document is to provide simple guidelines about Git workflow that is used in the Test Automation project.
**Branches**  
When someone start working on task he should create feature branch with name of the task he is currently working on PROPER PATH:

feat/{task number}/{task name}

All of the changes should be committed to this branch.  
Commits should be informational.  
After work is finished user should create Pull Request (PR) to main branch.  
It is advised to merge main to feature branch to resolve all conflicts, before creating PR.  

**Review**  
When PR is created everyone should find time to check it (whenever it's possible).  
When PR is changing anything about framework itself, every reviewer should run it and check if this particular change work (MAC vs Linux vs Windows).  
When there is many changes requested in PR after making changes review process should start from the beginning.  
There shouldn’t be situation when PR is hanging **more than three days**.

**Pull Request Merging**  
When PR is created it can be merged to main only if this PR got two approves by team QA and one approve from leader QA and all of the merge conflicts and discussions are resolved.  
All Browser Stack tests should be green on dedicated runners.  
Creator of Pull Request should use “squash commit” option, the merge commit should look like:

[ADD] {Task number} + short informational description

[FIX], [MOD], [DEL]: options will be explained on meeting

**Disagreement**  
When two of developers can’t resolve discussion/disagreement by themselves. Whole group try to find a solution.  
Conflicts can be resolved on automation QA channel.