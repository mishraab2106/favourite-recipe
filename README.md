# favourite-recipe
Deployment Instructions:-

Steps to dockerize and and run the application

Navigate to project folder where the Dockerfile exists and run the below build command

Step 1: Run command from the project directory favouriterecipe
---> docker build -t favourite-recipe.jar .

The same project folder also has the db folder so run the below docker command to persist the data. This db has sample data within it. 
Step 2: Run the below command to start the image and persist the data

-->docker run -d -v C:\Users\Mishr\Documents\GitHub\favourite-recipe\favouriterecipe\db:./db -p 8080:8080 favourite-recipe.jar

docker run -d -v <project folder path on local>\db:<folder on remote> -p 8080:8080 favourite-recipe.jar

for example C:\Users\Mishr\Documents\GitHub\favourite-recipe\favouriterecipe  is the path on my local machine where this project exists

To run this application on the local machine using IDE please follow the below steps.
-->Uncomment spring.datasource.url=jdbc:h2:file:./db/recipe;DB_CLOSE_ON_EXIT=FALSE and
Comment spring.datasource.url=jdbc:h2:file:/etc/db/recipe;DB_CLOSE_ON_EXIT=FALSE on the application.properties file and then save it 
and run the application.

Below are the Rest APIs which have been exposed and can be tested once the application starts running

Add a Recipe

http://localhost:8080/addrecipe

Update a recipe with id

http://localhost:8080/updaterecipe?id=1

Delete recipe with id

http://localhost:8080/deleterecipe?id=1

Fetch all recipe

http://localhost:8080/allrecipe

Fetch Recipe by name
http://localhost:8080/fetchrecipe?name=salmon

Rest API for All vegetarian recipes
http://localhost:8080/filterrecipe?veg=yes

Rest API for servings filter
http://localhost:8080/filterrecipe?servings=4

Rest API for ingredients filter either include or exclude
http://localhost:8080/filterrecipe?ingredients=chicken&ingredientscondition=exclude

http://localhost:8080/filterrecipe?ingredients=chicken&ingredientscondition=include

Rest API for instructions filter
http://localhost:8080/filterrecipe?instructions=boiling

Rest API for Recipes that can serve 4 persons and have “potatoes” as an ingredient

http://localhost:8080/filterrecipe?ingredients=potatoes&servings=4


Rest API for Recipes without “salmon” as an ingredient that has “oven” in the instructions.
http://localhost:8080/filterrecipe?ingredients=salmon&instructions=oven&ingredientscondition=exclude

Rest API with all the filters inplace
http://localhost:8080/filterrecipe?ingredientscondition=include&servings=3&instructions=boil water&veg=yes&ingredients=lentils
