# Android MVVM
MVVM stands for Model, View, ViewModel.

Model:

1.Same as in MVC/MVP pattern.

View:
1. Same as in MVC/MVP pattern.

ViewModel:
 	
1. It contains the Model.
2. Uses observable values for update values. An observable can deliver multiple values of any type.

-----------------------------------------------------------------------------------------------------------
![jhj](https://imgur.com/4igQxba.png)

Issues is arise in BR while implementing the BR.class.

solution:-Once data binding is integrated in layout file, goto Build -> Clean Project and Build -> Rebuild Project. This will generate necessary binding classes.
