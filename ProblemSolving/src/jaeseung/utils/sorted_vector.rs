use std::cmp::Ordering;

pub struct SortedVector<T> {
    pub vec: Vec<T>
}

impl<T: Ord + Clone> SortedVector<T> {

    pub const fn new() -> Self {
        Self { vec: Vec::new() }
    }

    pub fn vector(self, vec: &Vec<T>) -> Self {
        let mut new_vector = vec.clone();
        new_vector.sort();

        Self { vec: new_vector }
    }

    pub fn desc(mut self) -> Self {
        self.vec.reverse();
        self
    }

    pub const fn build(self) -> Self {
        self
    }

    pub fn binary_search(&self, target: T) -> Option<i32> {
        let mut low: i32 = 0;
        let mut high: i32 = self.vec.len() as i32 - 1;
    
        while low <= high {
            let mid = (low + high) / 2;
    
            match self.vec[mid as usize].cmp(&target) {
                Ordering::Less => low = mid + 1,
                Ordering::Greater => high = mid - 1,
                Ordering::Equal => return Some(mid),
            }
        }
        None
    }
}
