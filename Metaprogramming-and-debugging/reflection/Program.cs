using System;
using System.Linq;
using System.Reflection;
using pizzainterfaces;
using System.Collections.Generic;


namespace testreflection
{
    class MexicanaPizza : pizzainterfaces.IPizza
    {
        string IPizza.Description()
        {
            return "Spicy pizza";
        }
    }
    class MexicanaPizzaMaker : pizzainterfaces.IPizzaMaker
    {
        IPizza IPizzaMaker.CreatePizza()
        {
            return new MexicanaPizza();
        }
    }
    class RandomPizzaMaker : pizzainterfaces.IPizzaMaker
    {
        static Random rnd = new Random();

        IPizza IPizzaMaker.CreatePizza()
        {
            // TODO: Your code goes here
            AppDomain currentDomain = AppDomain.CurrentDomain;
            // Look through all loaded "assemblies" (the loaded .exe and .dll files)
            // for all classes that implement IPizza (and are concrete classes)
            Assembly[] assems = currentDomain.GetAssemblies();
            Console.WriteLine("List of assemblies loaded in current appdomain:");
            foreach (Assembly assem in assems)
                Console.WriteLine(assem.ToString());

            Type[] TPP = assems[3].GetTypes();
            Console.WriteLine(TPP);
            Type[] prog = assems[1].GetTypes();
            Console.WriteLine(prog);
            
            List<Type> pizzas = new List<Type>();

            foreach(Type type in TPP){
                
                
                    if(typeof(IPizza).IsAssignableFrom(type) && !type.IsAbstract){
                        Console.WriteLine(type);
                        pizzas.Add(type);
                    }
                    
                    
                
            }

            foreach(Type type in prog){
                 
                   if(typeof(IPizza).IsAssignableFrom(type) && !type.IsAbstract){
                        Console.WriteLine(type);
                        pizzas.Add(type);
                    }
            }
            
            //Choose one of classes implementing IPizza
            //rnd.next(number interval)
            Type randomPizza = pizzas[rnd.Next(0, pizzas.Count)];
            // Call the constructor of this class
            
            // CreateInstance retruns Type Object needs to be casted to IPizza
            IPizza resPizza = (IPizza)Activator.CreateInstance(randomPizza);
            return resPizza;
            throw new NotImplementedException();
        }
    }
    class MainClass
    {
        public static void Main(string[] args)
        {
            // You may change this to an absolute path if you are not running it from the same location as the README suggests.
            // You can also comment out loading the dll (for example for testing the code first), but make sure to load the dll when
            // handing in the final result.
            Assembly a = Assembly.LoadFrom("ThirdPartyPlugin.dll");
            IPizzaMaker pm = new RandomPizzaMaker();
            foreach (int i in Enumerable.Range(1, 20)) {
                IPizza pizza = pm.CreatePizza();
                Console.WriteLine("{0} - {1}", pizza, pizza.Description());
            }
        }
    }
}
