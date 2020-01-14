import numpy as np
import matplotlib.pyplot as plt
from sklearn.linear_model import LinearRegression
from sklearn.preprocessing import PolynomialFeatures


#Define some training data for the model
x_train = [[34],[18],[39],[45],[52]] #Size of cellphone
y_train = [[78],[82],[85],[90],[86]] #Price of cellphone

#Define some testing data for the model
x_test = [[19],[64],[27],[32]]
y_test = [[75],[90],[70],[74]]

#set the parameters for which values the line will show up on.
xx = np.linspace(0,100,100)

quadratic_featurizer = PolynomialFeatures(degree=2)

#Transform the input data matrix into a new data matrix of the degree defined above
x_train_quadratic = quadratic_featurizer.fit_transform(x_train)
x_test_quadratic = quadratic_featurizer.transform(x_test)

#Train and test the model
regressor_quadratic = LinearRegression()
regressor_quadratic.fit(x_train_quadratic, y_train)
xx_quadratic = quadratic_featurizer.transform(xx.reshape(xx.shape[0],1))

# Plot the graph
plt.plot(xx, regressor_quadratic.predict(xx_quadratic), c='r', linestyle='--')
plt.title('Cellphone size reqgressed on price')
plt.xlabel('Size')
plt.ylabel('Price')
plt.axis([0, 100, 0, 150])
plt.grid(True)
plt.scatter(x_train, y_train)
plt.show()
