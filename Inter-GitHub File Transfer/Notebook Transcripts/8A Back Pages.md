# 8A Notebook's Back Page Pseudo-Code
#### Aug. 20th (Tuesday)
> Registryless Tags 🏷️ (`melonystudios.registrylesstags`)

```java
public static Page getPageBySubject(ClassSubject subject, int page) {
  return this.pages.bySubject(subject).stream().filter(page1 -> page1 == page);
}
```

```java
public Page.Title[] titles = this.pages.getTitles();
```

```java
public class SchoolManager {
  @Nullable
  public final Notebook notebook;
  @Nullable
  public final Pencase pencase;
  public final Classroom classroom;

  public SchoolManager(Classroom classroom, @Nullable Notebook notebook, @Nullable Pencase pencase) {
    this.classroom = classroom;
    this.notebook = notebook;
    this.pencase = pencase;
  }
}
```

#### Feb. 28th (Wednesday)
```java
Introduction[].Problem.getDescription();
Development[].Args[].getDescription();
Conclusion[].InterventionProposal
Conclusion[].ThesisRealization
Conclusion[].ThemeComeback
Conclusion[].ProblemComeback
```

```java
this.notebook.
this.notebook.getPageBySubject("history" 4).titles.get("Uma nova" + " sociedade").getContents();
this.school.getTeacher("history", 8).getName();
this.school.getStudents(6, [includeOut] false);
this.notebook.getPageBySubject("nblang:history").titles.get("Independência no México").getContents();

this.pencase.getResource("highlighterPurple").getHighlightColor();
             \- getResource(String) might produce a NullPointerException.
```