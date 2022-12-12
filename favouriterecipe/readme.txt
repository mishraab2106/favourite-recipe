
docker build -t favourite-recipe.jar .

Step 1: Run command from the project directory codingtask
docker build -t favourite-recipe.jar .

Step 2: Run the below command to start the image
docker run -v ./recipe:/etc/recipe -p 8080:8080 favourite-recipe.jar 



Add a Recipe

http://localhost:8080/addrecipe

Update a recipe with id

http://localhost:8080/updaterecipe?id=1

Delete recipe with id

http://localhost:8080/deleterecipe?id=1

Fetch all recipe

http://localhost:8080/allrecipe

Rest API for All vegetarian recipes
http://localhost:8080/filterrecipe?veg=yes

Rest API for Recipes that can serve 4 persons and have “potatoes” as an ingredient
http://localhost:8080/recipewithingandservings?ingredients=potatoes&servings=4

Rest API for Recipes without “salmon” as an ingredient that has “oven” in the instructions.
http://localhost:8080/recipewithoutingandins?ingredients=salmon&instructions=oven

Rest API with all the filters intact
http://localhost:8080/filterrecipe?ingredientscondition=include&servings=3&instructions=boil water&veg=yes&ingredients=lentils