use std::{borrow::{Borrow, BorrowMut}, cmp::Ordering};

fn main() {

    let l1 = Some(Box::new(ListNode::new(9)));
    let l2 = Some(Box::new(ListNode::new(8)));

    let result = Solution::add_two_numbers(l1, l2);

    println!("{:?}", result);
}

struct Solution;

impl Solution {
    pub fn add_two_numbers(l1: Option<Box<ListNode>>, l2: Option<Box<ListNode>>) -> Option<Box<ListNode>> {
        match (l1, l2) {
            (None, None) => None,
            (Some(n), None) => Some(n),
            (None, Some(n)) => Some(n),
            (Some(n1), Some(n2)) => {
                let sum = n1.val + n2.val;

                if(sum < 10) {
                    Some(Box::new(ListNode {
                        val: sum,
                        next: Self::add_two_numbers(n1.next, n2.next),
                    }))
                } else {
                    let carry = Some(Box::new(ListNode::new(1)));

                    Some(Box::new(ListNode {
                        val: sum - 10,
                        next: Self::add_two_numbers(Self::add_two_numbers(carry, n1.next), n2.next),
                    }))
                }
            } 
        }
    }
}


#[derive(PartialEq, Eq, Clone, Debug)]
pub struct ListNode {
  pub val: i32,
  pub next: Option<Box<ListNode>>
}

impl ListNode {
  #[inline]
  fn new(val: i32) -> Self {
    ListNode {
      next: None,
      val
    }
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