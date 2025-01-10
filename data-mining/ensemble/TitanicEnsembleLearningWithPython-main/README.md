# <center> Machine Learning Project - Ensemble Learning <br>with Scikit-learn and Keras</center>
## <center>A Walk-through of the Project</center>
## <center>by Karine Legrand</center>
### <center>February 2022</center>

### Introduction and Goals:
<br>
We will continue using the well-known 'Titanic' Dataset with the Machine Learning library Scikit-Learn, to build several Ensemble Learning Models, grouping "weak" classification Learners, according different Techniques like Bagging, Boosting, and Voting Classifier. We will also design a Voting Classifier Model, using a Keras Neural Network Model.<br>
We will analyse the results and compare the performances of single and Ensemble Learners and analyse which model produces the best predictions on 'Survived' Response.

### Strategy followed to get to our Insights:

We will proceed through these different chronological steps:

#### 1) Data Acquisition, Wrangling and Preprocessing

We will use already cleaned Data from a previous Project, where the following necessary steps were taken care of:

- Fixing quality and tidiness issues (always needed)
- Formatting the data for scikit-learn (Machine Learning Models )or keras (Neural Network) specific use. For this it means, precisely to "One hot encode" categorical variables.
 

#### 2) Selecting Single Learners and comparing the Results
In this section we will first pick each of the Classifier Estimators that could be used alone to solve our Classification Problem. We will train each model with the training Data and compute the Accuracy of the Class Predictions on the Train and Test Sets, for each of them. <br>
We will inspect following classifiers:
- Decision Tree (DT)
- Gaussian Naive Bayes (GNB)
- Logistic Regression (LG)
- Stochastic Gradient Classifier (SGD)
- Support Vector Classifier (SVC)


#### 3) Selecting Ensemble Learners and comparing the Results.

In this section we will build, train and analyse the Performance of several Ensemble Models:<br>

- Random Forest Classifier
- Bagging Classifier
- Ada Boost Classifier
- Gradient Boosting Classifier
- Extreme Gradient Boosting Classifier - "XGBoost"
- Voting Classifier with (LG, RF, SVC)
- Voting Classifier with (GNB, DT, SGD)

#### 4) Build a Voting Classifier with a Neural Network:
Finally in Appendix we will add a Neural Network as an additional Classifier to a Voting Classifier Ensemble. We will therefore, use a Neural Network built in a previous Project on the same Dataset:

We have 11 Input units (one for each feature), 2 hidden layers, each with 32 neurons and a 'ReLu' activation function,
1 output layer with a single unit, since we predict two levels of a binary class (Survived:1 or zero), and a sigmoid activation function, which outputs a number between 0 and 1.

### Conclusion and Limitations

The Ensemble Learning Approach has enabled us to build different Models that performed quite good at predicting wether a Passenger did survive the 'Titanic' Tragedy based on its Characteristics. We first built different typical Machine Learning Single Classifiers and moved on to implement different Ensemble Learning Techniques using these single Classifiers. We could even build a <b>Voting Classifier</b> Ensemble, containting a Keras Neural Network Model.<br>
The best Performance obtained in terms of Accuracy of Prediction on Test Data were obtained by the:
- <b>Decision Tree</b> Classifier with $85.1\%$ accuracy on Train data, $79.2\%$ on Test data and $2.13ms$ training time
- <b>Random Forest</b> Classifier with $92.3\%$ accuracy on Train data, $79.8\%$ on Test data and $93.9ms$ training time
- <b>XGBoost</b> Classifier with $98.5\%$ Accuracy on Train data, $79.8\%$ on Test data and $104ms$ training time
<br>
<br>

Limitation: the performance of our Models depend on the quantity of the data samples available. This Dataset contains less than 1000 samples which is not much to work with. The Results are actually quite satisfying, considering this limitation. The reason is, as we could show with an Exploratory Data Analysis, that the Response is strongly correlated with some features in the Dataset ('Gender' and 'Class of Travelling' for example). The single and Ensembe learning Models make this correlation speak!

