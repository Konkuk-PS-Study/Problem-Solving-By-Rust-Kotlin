use std::cmp::Ordering;

fn main() {

    let nums = vec![3,2,4];
    let target = 6;

    let result = Solution::two_sum(nums, target);

    println!("{:?}", result);
}

struct Solution;

impl Solution {
    pub fn two_sum(nums: Vec<i32>, target: i32) -> Vec<i32> {
        let sorted_vec = SortedVector::new().vector(&nums).build();
    
        for (i, el) in nums.iter().enumerate() {
            let other = target - el;
            let other_opt = sorted_vec.binary_search(other);

            match other_opt {
                Some(_) => {
                    let idx = nums.iter().position(|x| *x == other);
                    let idx_1 = i as i32;
                    let idx_2 = idx.unwrap() as i32;

                    if idx_1 == idx_2 {
                        continue;
                    }

                    return vec![idx_1, idx_2];
                },
                _ => continue
            }
        }

        return Vec::new();
    }
}

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