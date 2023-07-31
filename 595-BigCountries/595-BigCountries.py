import pandas as pd

def big_countries(world: pd.DataFrame) -> pd.DataFrame:
    world = world[(world['area'] >= 3000000) | (world['population'] >= 25000000)]
    return world[['name','population', 'area']]
