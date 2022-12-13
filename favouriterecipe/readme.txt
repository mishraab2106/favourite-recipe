
docker build -t favourite-recipe.jar .

Step 1: Run command from the project directory favouriterecipe
docker build -t favourite-recipe.jar .

Step 2: Run the below command to start the image and persist the data

docker run -d -v C:\Users\Mishr\Documents\GitHub\favourite-recipe\favouriterecipe\db:/etc/db -p 8080:8080 favourite-recipe.jar

docker run -d -v <project folder path on local>\db:<folder on remote> -p 8080:8080 favourite-recipe.jar

for example C:\Users\Mishr\Documents\GitHub\favourite-recipe\favouriterecipe  is the path on my local machine where this project exists




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